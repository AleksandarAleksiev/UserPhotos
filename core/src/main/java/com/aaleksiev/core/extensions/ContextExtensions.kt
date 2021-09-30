package com.aaleksiev.core.extensions

import android.content.Context
import android.view.LayoutInflater

fun Context.layoutInflater(): LayoutInflater = LayoutInflater.from(this)