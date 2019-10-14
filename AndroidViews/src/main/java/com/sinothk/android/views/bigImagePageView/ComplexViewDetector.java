package com.sinothk.android.views.bigImagePageView;

import android.view.View;

import androidx.annotation.NonNull;

/**
 * Helper interface that allows to check if view is complex or not.
 */
public interface ComplexViewDetector {

    /**
     * Check if view is a complex view.
     *
     * @param view some view
     * @return true if view is complex, false otherwise
     */
    boolean isComplexView(@NonNull View view);
}
