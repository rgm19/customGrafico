package principal.customizecomponets_ruben;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;



/**
 * Created by ruben on 26/01/17.
 */

public class TartaGrafica extends View {

    private Paint pie;
    private RectF rectF;
    private float[] data;

    public TartaGrafica(Context context, AttributeSet attrs){
        super(context, attrs);

        pie=new Paint();
        pie.setAntiAlias(true);
        pie.setDither(true);
        pie.setStyle(Paint.Style.FILL);
    }

    private float[] pieSegment(){

        float [] segValues =new float[this.data.length];
        float total = getTotal();

        for(int i=0;i<this.data.length;i++){
            segValues[i]=(this.data[i]/total)*360;
        }

        return segValues;
    }

    private float getTotal(){

        float total=0;
        for(float val: this.data){
            total+=val;
        }
        return total;
    }

    @Override
    protected void onDraw(Canvas canvas){
        if(data!=null){
            int top = 0;
            int left = 0;
            int endBottom = getHeight();
            int endRight = endBottom;

            rectF= new RectF(left, top, endRight, endBottom);




            float[]segment= pieSegment();

            float segStartPoint=0;

            for(int i=0;i<segment.length;i++){
                Random rnd = new Random();
                int color = Color.argb(255, (int)segment[i],rnd.nextInt(256),rnd.nextInt(256));

                pie.setColor(color);
                canvas.drawArc(rectF, segStartPoint, segment[i], true, pie);
                segStartPoint+=segment[i];
            }
        }
    }

    public void setData(float[]data){
        this.data=data;
        invalidate();
    }
}
