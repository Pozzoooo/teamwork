package com.pozzo.teamwork.architecture.mvp

import java.lang.ref.WeakReference

/**
 * @since 27/07/17.
 */
abstract class BasePresenter<V : BaseView> {
    private var view: WeakReference<V>? = null

    fun takeView(view: V) {
        if (this.view != null) {
            dropView()
        }

        this.view = WeakReference(view)
        onLoad()
    }

    fun dropView() {
        this.view = null
    }

    protected fun getView(): V {
        if (view == null) {
            throw IllegalStateException("Should take view before getting it")
        }
        return view!!.get()!!
    }

    protected abstract fun onLoad()
}
