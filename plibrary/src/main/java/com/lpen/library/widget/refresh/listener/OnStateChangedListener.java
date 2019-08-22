package com.lpen.library.widget.refresh.listener;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.lpen.library.widget.refresh.api.RefreshLayout;
import com.lpen.library.widget.refresh.constant.RefreshState;

import static androidx.annotation.RestrictTo.Scope.*;

/**
 * 刷新状态改变监听器
 * Created by SCWANG on 2017/5/26.
 */

public interface OnStateChangedListener {
    /**
     * 状态改变事件 {@link RefreshState}
     * @param refreshLayout RefreshLayout
     * @param oldState 改变之前的状态
     * @param newState 改变之后的状态
     */
    @RestrictTo({LIBRARY,LIBRARY_GROUP,SUBCLASSES})
    void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState oldState, @NonNull RefreshState newState);
}
