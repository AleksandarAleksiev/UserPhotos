package com.aaleksiev.core.viewbinding

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * Delegate to inline binding of views.
 * Source: https://medium.com/@Zhuinden/simple-one-liner-viewbinding-in-fragments-and-activities-with-kotlin-961430c6c07c
 * Source of the update to fix a bug: https://itnext.io/an-update-to-the-fragmentviewbindingdelegate-the-bug-weve-inherited-from-autoclearedvalue-7fc0a89fcae1
 *
 * @param onStopBindingCallback - used this callback to stop listeners attached to the views
 */
class FragmentViewBindingDelegate<T : ViewBinding>(
    val fragment: Fragment,
    val viewBindingFactory: (View) -> T,
    val destroyBindingCallback: ((T) -> Unit)? = null,
    val onStopBindingCallback: (() -> Unit)? = null
) : ReadOnlyProperty<Fragment, T> {
    private var binding: T? = null

    init {
        fragment.lifecycle.addObserver(object : DefaultLifecycleObserver {
            val viewLifecycleOwnerLiveDataObserver =
                Observer<LifecycleOwner?> { lifecycleOwner ->

                    val viewLifecycleOwner = lifecycleOwner ?: return@Observer
                    viewLifecycleOwner.lifecycle.addObserver(object : DefaultLifecycleObserver {
                        override fun onDestroy(owner: LifecycleOwner) {
                            //because the lifecycle onDestroy callback is invoked before the fragment onDestroyView
                            //if have released any references in onDestroyView now we have to release them in destroyBindingCallback
                            //because if we try to access the already destroyed binding in onDestroyView it throws an exception
                            binding?.let {
                                destroyBindingCallback?.invoke(it)
                            }
                            binding = null
                        }

                        override fun onStop(owner: LifecycleOwner) {
                            onStopBindingCallback?.invoke()
                        }
                    })
                }

            override fun onCreate(owner: LifecycleOwner) {
                fragment.viewLifecycleOwnerLiveData.observeForever(
                    viewLifecycleOwnerLiveDataObserver
                )
            }

            override fun onDestroy(owner: LifecycleOwner) {
                fragment.viewLifecycleOwnerLiveData.removeObserver(
                    viewLifecycleOwnerLiveDataObserver
                )
            }
        })
    }

    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        val binding = binding
        if (binding != null) {
            return binding
        }

        val lifecycle = fragment.viewLifecycleOwner.lifecycle
        if (!lifecycle.currentState.isAtLeast(Lifecycle.State.INITIALIZED)) {
            throw IllegalStateException("Should not attempt to get bindings when Fragment views are destroyed.")
        }

        return viewBindingFactory(thisRef.requireView()).also { this.binding = it }
    }
}

/**
 * @param onDestroyBindingCallback - releases references in memory to avoid leaks
 */
fun <T : ViewBinding> Fragment.viewBinding(
    viewBindingFactory: (View) -> T,
    onDestroyBindingCallback: ((T) -> Unit)? = null,
    onStopBindingCallback: (() -> Unit)? = null
) =
    FragmentViewBindingDelegate(
        this,
        viewBindingFactory,
        onDestroyBindingCallback,
        onStopBindingCallback
    )