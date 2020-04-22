package com.cooleyepetizer.app.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.cooleyepetizer.app.R;
import com.github.ybq.android.spinkit.style.ChasingDots;
import com.github.ybq.android.spinkit.style.Circle;
import com.github.ybq.android.spinkit.style.Wave;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.wang.avi.AVLoadingIndicatorView;

public class CustomHeader extends LinearLayout implements RefreshHeader {

    private Wave mWaveDrawable;
    private Circle mCircleDrawable;
    private ChasingDots mChasingDotsDrawable;

    private TextView mHeaderText;
    private ImageView mImage;
    private AVLoadingIndicatorView aiv;

    public CustomHeader(Context context) {
        this(context, null, 0);
    }

    public CustomHeader(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomHeader(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = View.inflate(context, R.layout.eye_refresh_head, this);
        mImage = view.findViewById(R.id.im_refresh_header);
        mHeaderText = view.findViewById(R.id.tv_refresh_header);
        aiv = view.findViewById(R.id.aiv);
        mWaveDrawable = new Wave();
        mCircleDrawable = new Circle();
        mChasingDotsDrawable = new ChasingDots();
        mWaveDrawable.setColor(getResources().getColor(R.color.colorAccent));
        mCircleDrawable.setColor(getResources().getColor(R.color.colorAccent));
        mChasingDotsDrawable.setColor(getResources().getColor(R.color.colorAccent));
    }

    @NonNull
    @Override
    public View getView() {
        return this;
    }

    @NonNull
    @Override
    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.Translate;
    }

    @Override
    public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState oldState, @NonNull RefreshState newState) {
        switch (newState) {
            case None:
            case PullDownToRefresh:
                mImage.setVisibility(VISIBLE);
                mHeaderText.setText("下拉开始刷新");
                mImage.setImageDrawable(mCircleDrawable);
                mCircleDrawable.start();
                aiv.show();
                break;
            case Refreshing:
                mImage.setVisibility(VISIBLE);
                mHeaderText.setText("正在刷新数据");
                mImage.setImageDrawable(mCircleDrawable);
                mCircleDrawable.start();
                aiv.show();
                break;
            case ReleaseToRefresh:
                mImage.setVisibility(VISIBLE);
                mHeaderText.setText("释放立即刷新");
                mImage.setImageDrawable(mCircleDrawable);
                mCircleDrawable.start();
                aiv.show();
                break;
        }
    }

    @Override
    public void onStartAnimator(@NonNull RefreshLayout refreshLayout, int height, int maxDragHeight) {
        mCircleDrawable.start();
    }

    @Override
    public int onFinish(@NonNull RefreshLayout refreshLayout, boolean success) {
        if (success){
            mImage.setVisibility(GONE);
            mHeaderText.setText("刷新完成");
        } else {
            mHeaderText.setText("刷新失败");
            mImage.setVisibility(GONE);
        }
        if (mCircleDrawable!=null){
            mCircleDrawable.stop();
        }
        aiv.hide();
        return 500;
    }

    @Override
    public void setPrimaryColors(int... colors) {

    }

    @Override
    public void onInitialized(@NonNull RefreshKernel kernel, int height, int maxDragHeight) {

    }

    @Override
    public void onMoving(boolean isDragging, float percent, int offset, int height, int maxDragHeight) {

    }

    @Override
    public void onReleased(@NonNull RefreshLayout refreshLayout, int height, int maxDragHeight) {

    }

    @Override
    public void onHorizontalDrag(float percentX, int offsetX, int offsetMax) {

    }

    @Override
    public boolean isSupportHorizontalDrag() {
        return false;
    }

}

