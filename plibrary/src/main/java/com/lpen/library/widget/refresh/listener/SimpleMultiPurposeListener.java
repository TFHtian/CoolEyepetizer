package com.lpen.library.widget.refresh.listener;

import androidx.annotation.NonNull;
import com.lpen.library.widget.refresh.api.RefreshFooter;
import com.lpen.library.widget.refresh.api.RefreshHeader;
import com.lpen.library.widget.refresh.api.RefreshLayout;
import com.lpen.library.widget.refresh.constant.RefreshState;

/**
 * 多功能监听器
 * Created by SCWANG on 2017/5/26.
 */

public class SimpleMultiPurposeListener implements OnMultiPurposeListener {

//    @Override
//    public void onHeaderPulling(RefreshHeader header, float percent, int offset, int headerHeight, int maxDragHeight) {
//
//    }

    @Override
    public void onHeaderMoving(RefreshHeader header, boolean isDragging, float percent, int offset, int headerHeight, int maxDragHeight) {

    }

    @Override
    public void onHeaderReleased(RefreshHeader header, int headerHeight, int maxDragHeight) {

    }

//    @Override
//    public void onHeaderReleasing(RefreshHeader header, float percent, int offset, int footerHeight, int maxDragHeight) {
//
//    }

    @Override
    public void onHeaderStartAnimator(RefreshHeader header, int footerHeight, int maxDragHeight) {

    }

    @Override
    public void onHeaderFinish(RefreshHeader header, boolean success) {

    }

    @Override
    public void onFooterMoving(RefreshFooter footer, boolean isDragging, float percent, int offset, int footerHeight, int maxDragHeight) {

    }

//    @Override
//    public void onFooterPulling(RefreshFooter footer, float percent, int offset, int footerHeight, int maxDragHeight) {
//
//    }

    @Override
    public void onFooterReleased(RefreshFooter footer, int footerHeight, int maxDragHeight) {

    }

//    @Override
//    public void onFooterReleasing(RefreshFooter footer, float percent, int offset, int footerHeight, int maxDragHeight) {
//
//    }

    @Override
    public void onFooterStartAnimator(RefreshFooter footer, int headerHeight, int maxDragHeight) {

    }

    @Override
    public void onFooterFinish(RefreshFooter footer, boolean success) {

    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {

    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {

    }

    @Override
    public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState oldState, @NonNull RefreshState newState) {

    }

}