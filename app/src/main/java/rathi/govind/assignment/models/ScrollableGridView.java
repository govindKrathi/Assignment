package rathi.govind.assignment.models;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.GridView;

/**
 * Custom GridView to support the srolling feature along with other components on Activity.
 */
public class ScrollableGridView extends GridView{

        public ScrollableGridView(Context context) {
            super(context);
        }

        public ScrollableGridView(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        public ScrollableGridView(Context context, AttributeSet attrs, int defStyle)   {
            super(context, attrs, defStyle);
        }

        @Override
        public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            int heightMeasureSpec_custom = MeasureSpec.makeMeasureSpec(
                    Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
            super.onMeasure(widthMeasureSpec, heightMeasureSpec_custom);
            ViewGroup.LayoutParams params = getLayoutParams();
            params.height = getMeasuredHeight();
        }

}
