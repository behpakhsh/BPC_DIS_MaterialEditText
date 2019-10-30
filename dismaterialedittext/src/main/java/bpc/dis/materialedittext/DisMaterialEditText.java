package bpc.dis.materialedittext;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class DisMaterialEditText extends FrameLayout {

    private TextInputLayout txtLayout;
    private TextInputEditText txtInput;
    private String errorMessage;

    public DisMaterialEditText(@NonNull Context context) {
        super(context);
        init(context, null, 0);
    }

    public DisMaterialEditText(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public DisMaterialEditText(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    public void init(Context context, AttributeSet attrs, int defStyleAttr) {
        View view = inflate(context, R.layout.dis_material_edit_text, this);
        txtLayout = view.findViewById(R.id.txt_layout);
        txtInput = view.findViewById(R.id.txt_input);
        setupView(context, attrs);
    }

    private void setupView(Context context, AttributeSet attrs) {
        TypedArray styledAttributes = context.obtainStyledAttributes(attrs, R.styleable.DisMaterialEditText);

        int backgroundColor = styledAttributes.getColor(R.styleable.DisMaterialEditText_disBackground, context.getResources().getColor(R.color.disBackgroundColor));
        setBackground(backgroundColor);

        String text = styledAttributes.getString(R.styleable.DisMaterialEditText_disText);
        setText(text);

        int textColor = styledAttributes.getColor(R.styleable.DisMaterialEditText_disTextColor, context.getResources().getColor(R.color.disTextColor));
        setTextColor(textColor);

        float textSize = styledAttributes.getDimension(R.styleable.DisMaterialEditText_disTextSize, context.getResources().getDimension(R.dimen.disTextSize));
        setTextSize(textSize);

        String hint = styledAttributes.getString(R.styleable.DisMaterialEditText_disHint);
        setHint(hint);

        int hintColor = styledAttributes.getColor(R.styleable.DisMaterialEditText_disHintColor, context.getResources().getColor(R.color.disHintColor));
        setHintColor(hintColor);

        boolean errorEnable = styledAttributes.getBoolean(R.styleable.DisMaterialEditText_disErrorEnable, false);
        setErrorEnable(errorEnable);

        boolean passwordToggleEnable = styledAttributes.getBoolean(R.styleable.DisMaterialEditText_disErrorEnable, false);
        setPasswordToggleEnable(passwordToggleEnable);

        errorMessage = styledAttributes.getString(R.styleable.DisMaterialEditText_disError);

        int lineColor = styledAttributes.getColor(R.styleable.DisMaterialEditText_disLineColor, context.getResources().getColor(R.color.disLineColor));
        setLineColor(lineColor);

        int textStyle = styledAttributes.getInteger(R.styleable.DisMaterialEditText_disTextStyle, 0); // normal
        setTextStyle(textStyle);

        int gravity = styledAttributes.getInteger(R.styleable.DisMaterialEditText_disGravity, 17); // center
        setGravity(gravity);

        int inputType = styledAttributes.getInteger(R.styleable.DisMaterialEditText_disInputType, 1); // text
        setInputType(inputType);

        int direction = styledAttributes.getInteger(R.styleable.DisMaterialEditText_disDirection, 1); // rtl
        setDirection(direction);

        int maxLength = styledAttributes.getColor(R.styleable.DisMaterialEditText_disMaxLength, 0); // any character
        setMaxLength(maxLength);


        styledAttributes.recycle();
    }

    public void setInputType(int inputType) {
        txtInput.setInputType(inputType);
    }

    public void setMaxLength(int maxLength) {
        if (maxLength > 0) {
            InputFilter[] filterArray = new InputFilter[1];
            filterArray[0] = new InputFilter.LengthFilter(maxLength);
            txtInput.setFilters(filterArray);
        }
    }

    public void setGravity(int gravity) {
        txtLayout.setGravity(gravity);
        txtInput.setGravity(gravity);
    }


    public void setDirection(int direction) {
        txtLayout.setLayoutDirection(direction);
        txtInput.setLayoutDirection(direction);
    }

    public void setTextStyle(int textStyle) {
        txtInput.setTypeface(txtInput.getTypeface(), textStyle);
    }

    public void setBackground(int backgroundColor) {
        txtLayout.setBackgroundColor(backgroundColor);
    }

    public void setPasswordToggleEnable(boolean passwordToggleEnable) {
        txtLayout.setPasswordVisibilityToggleEnabled(passwordToggleEnable);
    }

    public void setLineColor(int color) {
        Drawable background;
        if (txtLayout.getEditText() == null) {
            background = txtInput.getBackground();
        } else {
            background = txtLayout.getEditText().getBackground();
        }
        DrawableCompat.setTint(background, color);
        txtLayout.getEditText().setBackground(background);
    }

    public void setText(String text) {
        txtInput.setText(text);
    }

    public void setTextColor(int textColor) {
        txtInput.setTextColor(textColor);
    }

    public void setTextSize(float textSize) {
        textSize = textSize / getResources().getDisplayMetrics().density;
        txtInput.setTextSize(textSize);
    }

    public void setHint(String hint) {
        txtLayout.setHint(hint);
    }

    public void setHintColor(int hintColor) {
        txtLayout.setDefaultHintTextColor(ColorStateList.valueOf(hintColor));
        txtInput.setHintTextColor(hintColor);
    }

    public void setErrorEnable(boolean errorEnable) {
        txtLayout.setErrorEnabled(errorEnable);
    }

    public void showError() {
        if (errorMessage == null) {
            txtLayout.setError("Error Not Set In XML!");
        } else {
            txtLayout.setError(errorMessage);
        }
    }

    public void showError(String message) {
        txtLayout.setError(message);
    }

    public void hideError() {
        txtLayout.setError(null);
    }

}