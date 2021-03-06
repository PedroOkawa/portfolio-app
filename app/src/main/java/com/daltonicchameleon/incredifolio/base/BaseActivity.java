package com.daltonicchameleon.incredifolio.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.daltonicchameleon.incredifolio.App;
import com.daltonicchameleon.incredifolio.di.app.AppComponent;

/**
 * portfolio-app
 * Created in 3/20/17 by the following authors:
 * Pedro Okawa
 */
public abstract class BaseActivity<T extends ViewDataBinding> extends AppCompatActivity {

    private T dataBinding;

    @Override
    protected final void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getIntent().getExtras() != null) {
            initializesArguments(getIntent().getExtras());
        }

        initializesDataBinding();
        initializesComponents(getApp().getAppComponent());
        doOnCreated(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        dataBinding.unbind();
        super.onDestroy();
    }

    /**
     * Returns layout to inflate from the extended activity
     *
     * @return layoutId
     */
    protected abstract @LayoutRes int layoutToInflate();

    /**
     * Called when all features are initialized and loaded (databinding and Dagger components)
     *
     * @param savedInstanceState
     */
    protected abstract void doOnCreated(@Nullable Bundle savedInstanceState);

    /**
     * Initializes activity's arguments
     *
     * @param bundle
     */
    protected void initializesArguments(Bundle bundle) {

    }

    /**
     * Used to initializes extended activity components
     *
     * @param appComponent
     */
    protected void initializesComponents(AppComponent appComponent) {

    }

    /**
     * Initializes databinding instance based on extended activity layout (layoutToInflate)
     */
    private void initializesDataBinding() {
        this.dataBinding = DataBindingUtil.setContentView(this, layoutToInflate());
    }

    /**
     * Returns Activity data binding
     *
     * @return dataBinding
     */
    public T getDataBinding() {
        return dataBinding;
    }

    /**
     * Returns custom App instance to retrieve AppComponent
     *
     * @return app
     */
    public final App getApp() {
        return App.class.cast(getApplication());
    }

    /**
     * Returns content layout to inflate fragments
     *
     * @return content layout
     */
    public @IdRes int contentViewId() {
        return 0;
    }
}
