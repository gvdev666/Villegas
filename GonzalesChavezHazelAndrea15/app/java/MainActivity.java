import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
 
import org.chavezgonzaleshazelandrea15.math.mxparser.Argument;
import org.chavezgonzaleshazelandrea15.math.mxparser.Expression;
 
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
 
public class ScientificCalculatorActivity extends AppCompatActivity {
 
 
    private static final String TAG = ScientificCalculatorActivity.class.getSimpleName();
 
    Unbinder unbinder;
    @BindView(R.id.result_tv)
 
    TextView resultTv;
    @BindView(R.id.keys_pressed_tv)
 
    TextView keysPressedTv;
    @BindView(R.id.key_rad_operation)
 
    TextView keyRadOperation;
    @BindView(R.id.key_delete)
 
    TextView keyDelete;
    @BindView(R.id.key_cls)
 
    TextView keyCls;
 
    private int count = 0;
    private boolean mRADorDEG = false;
    private String text = "";
    private String expression = "";
    private String mRadOrDeg = "RAD";
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
 
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scientific_calculator);
 
        ActionBar actionBar = getSupportActionBar();
        if(null != actionBar){
            actionBar.hide();
        }
 
        unbinder = ButterKnife.bind(this);
 
        Argument x = new Argument("x");
        x.setArgumentExpressionString("2x + 5 = 7");
 
        Expression expression = new Expression("solve("+x.getArgumentExpressionString()+")",x);
        Log.d("CHECKER",""+expression.calculate()+" Expression String "+expression.getExpressionString());
 
        resultTv.setText("0");
    }
 
 
    @OnClick({R.id.key_percent, R.id.key_open_bracket, R.id.key_close_bracket, R.id.key_divide_operation, R.id.key_seven,
            R.id.key_eight, R.id.key_nine, R.id.key_multiply_operation, R.id.key_four, R.id.key_five, R.id.key_six,
            R.id.key_subtract_operation, R.id.key_one, R.id.key_two, R.id.key_three, R.id.key_addition_operation,
            R.id.key_zero, R.id.key_dot, R.id.key_delete, R.id.key_submission_operation, R.id.key_rad_operation,
            R.id.key_sin_operation, R.id.key_cos_operation, R.id.key_tan_operation, R.id.key_pi_operation, R.id.key_asin_operation,
            R.id.key_acos_operation, R.id.key_atan_operation, R.id.key_raised_pwr_minus_one_operation, R.id.key_raised_pwr_two_operation,
            R.id.key_raised_pwr_three_operation, R.id.key_raised_pwr_operation, R.id.key_log_operation, R.id.key_lg_operation, R.id.key_cls,
            R.id.key_ln_operation, R.id.key_e_operation, R.id.key_sqrroot_operation, R.id.key_cuberoot_operation, R.id.key_factorial_operation})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.key_percent:
                keysPressedTv.setText(keysPressedTv.getText() + "%");
                carryOutCalculation();
                break;
            case R.id.key_open_bracket:
                if (lastLetterIsCloseBracketOrNumbers()) {
                    keysPressedTv.setText(keysPressedTv.getText() + "x(");
                } else
                    keysPressedTv.setText(keysPressedTv.getText() + "(");
                break;
            case R.id.key_close_bracket:
                keysPressedTv.setText(keysPressedTv.getText() + ")");
                carryOutCalculation();
                break;
            case R.id.key_divide_operation:
                operatorClicked("÷");
                break;
            case R.id.key_seven:
                if (lastLetterIsCloseBracket()) {
                    keysPressedTv.setText(keysPressedTv.getText() + "x7");
                } else
                    keysPressedTv.setText(keysPressedTv.getText() + "7");
                carryOutCalculation();
                break;
            case R.id.key_eight:
                if (lastLetterIsCloseBracket()) {
                    keysPressedTv.setText(keysPressedTv.getText() + "x8");
                } else
                    keysPressedTv.setText(keysPressedTv.getText() + "8");
                carryOutCalculation();
                break;
            case R.id.key_nine:
                if (lastLetterIsCloseBracket()) {
                    keysPressedTv.setText(keysPressedTv.getText() + "x9");
                } else
                    keysPressedTv.setText(keysPressedTv.getText() + "9");
                carryOutCalculation();
                break;
            case R.id.key_multiply_operation:
                operatorClicked("x");
                break;
            case R.id.key_four:
                if (lastLetterIsCloseBracket()) {
                    keysPressedTv.setText(keysPressedTv.getText() + "x4");
                } else
                    keysPressedTv.setText(keysPressedTv.getText() + "4");
                carryOutCalculation();
                break;
            case R.id.key_five:
                if (lastLetterIsCloseBracket()) {
                    keysPressedTv.setText(keysPressedTv.getText() + "x5");
                } else
                    keysPressedTv.setText(keysPressedTv.getText() + "5");
                carryOutCalculation();
                break;
            case R.id.key_six:
                if (lastLetterIsCloseBracket()) {
                    keysPressedTv.setText(keysPressedTv.getText() + "x6");
                } else
                    keysPressedTv.setText(keysPressedTv.getText() + "6");
                carryOutCalculation();
                break;
            case R.id.key_subtract_operation:
                operatorClicked("-");
                break;
            case R.id.key_one:
                if (lastLetterIsCloseBracket()) {
                    keysPressedTv.setText(keysPressedTv.getText() + "x1");
                } else
                    keysPressedTv.setText(keysPressedTv.getText() + "1");
                carryOutCalculation();
                break;
            case R.id.key_two:
                if (lastLetterIsCloseBracket()) {
                    keysPressedTv.setText(keysPressedTv.getText() + "x2");
                } else
                    keysPressedTv.setText(keysPressedTv.getText() + "2");
                carryOutCalculation();
                break;
            case R.id.key_three:
                if (lastLetterIsCloseBracket()) {
                    keysPressedTv.setText(keysPressedTv.getText() + "x3");
                } else
                    keysPressedTv.setText(keysPressedTv.getText() + "3");
                carryOutCalculation();
                break;
            case R.id.key_addition_operation:
                operatorClicked("+");
                break;
            case R.id.key_zero:
                keysPressedTv.setText(keysPressedTv.getText() + "0");
                carryOutCalculation();
                break;
            case R.id.key_dot:
                if (count == 0 && keysPressedTv.length() != 0) {
                    keysPressedTv.setText(keysPressedTv.getText() + ".");
                    count++;
                }
                break;
            case R.id.key_delete:
                deleteKeyClicked();
                break;
            case R.id.key_submission_operation:
                if (keysPressedTv.getText().toString().length() != 0) {
                    keyDelete.setVisibility(View.GONE);
                    keyCls.setVisibility(View.VISIBLE);
                    carryOutCalculation();
                }
                break;
            case R.id.key_rad_operation:
                if (mRADorDEG) {
                    keyRadOperation.setText("RAD");
                    mRadOrDeg = "RAD";
                    mRADorDEG = false;
                } else {
                    keyRadOperation.setText("DEG");
                    mRadOrDeg = "DEG";
                    mRADorDEG = true;
                }
            
                String mKeyPressed = keysPressedTv.getText().toString();
                if (mKeyPressed.contains("sin(") || mKeyPressed.contains("asin(") || mKeyPressed.contains("cos(")
                        || mKeyPressed.contains("acos(") || mKeyPressed.contains("tan(") || mKeyPressed.contains("atan(")) {
                    carryOutCalculation();
                }
                break;
            case R.id.key_sin_operation:
                if (lastLetterIsCloseBracketOrNumbers()) {
                    keysPressedTv.setText(keysPressedTv.getText() + "xsin(");
                } else
                    keysPressedTv.setText(keysPressedTv.getText() + "sin(");
                break;
            case R.id.key_cos_operation:
                if (lastLetterIsCloseBracketOrNumbers()) {
                    keysPressedTv.setText(keysPressedTv.getText() + "xcos(");
                } else
                    keysPressedTv.setText(keysPressedTv.getText() + "cos(");
                break;
            case R.id.key_tan_operation:
                if (lastLetterIsCloseBracketOrNumbers()) {
                    keysPressedTv.setText(keysPressedTv.getText() + "xtan(");
                } else
                    keysPressedTv.setText(keysPressedTv.getText() + "tan(");
                break;
            case R.id.key_pi_operation:
                if (lastLetterIsCloseBracketOrNumbers()) {
                    keysPressedTv.setText(keysPressedTv.getText() + "xπ");
                } else
                    keysPressedTv.setText(keysPressedTv.getText() + "π");
                carryOutCalculation();
                break;
            case R.id.key_asin_operation:
                if (lastLetterIsCloseBracketOrNumbers()) {
                    keysPressedTv.setText(keysPressedTv.getText() + "xasin(");
                } else
                    keysPressedTv.setText(keysPressedTv.getText() + "asin(");
                break;
            case R.id.key_acos_operation:
                if (lastLetterIsCloseBracketOrNumbers()) {
                    keysPressedTv.setText(keysPressedTv.getText() + "xacos(");
                } else
                    keysPressedTv.setText(keysPressedTv.getText() + "acos(");
                break;
            case R.id.key_atan_operation:
                if (lastLetterIsCloseBracketOrNumbers()) {
                    keysPressedTv.setText(keysPressedTv.getText() + "xtan(");
                } else
                    keysPressedTv.setText(keysPressedTv.getText() + "atan(");
                break;
            case R.id.key_raised_pwr_minus_one_operation:
                keysPressedTv.setText(keysPressedTv.getText() + "\u207B\u00B9");
                carryOutCalculation();
                break;
            case R.id.key_raised_pwr_two_operation:
                keysPressedTv.setText(keysPressedTv.getText() + "²");
                carryOutCalculation();
                break;
            case R.id.key_raised_pwr_three_operation:
                keysPressedTv.setText(keysPressedTv.getText() + "\u00B3");
                carryOutCalculation();
                break;
            case R.id.key_raised_pwr_operation:
                keysPressedTv.setText(keysPressedTv.getText() + "\u2303");
                break;
            case R.id.key_log_operation:
                if (lastLetterIsCloseBracketOrNumbers()) {
                    keysPressedTv.setText(keysPressedTv.getText() + "xlog(");
                } else
                    keysPressedTv.setText(keysPressedTv.getText() + "log(");
                break;
            case R.id.key_lg_operation:
                if (lastLetterIsCloseBracketOrNumbers()) {
                    keysPressedTv.setText(keysPressedTv.getText() + "xlg(");
                } else
                    keysPressedTv.setText(keysPressedTv.getText() + "lg(");
                break;
            case R.id.key_ln_operation:
                if (lastLetterIsCloseBracketOrNumbers()) {
                    keysPressedTv.setText(keysPressedTv.getText() + "xln(");
                } else
                    keysPressedTv.setText(keysPressedTv.getText() + "ln(");
                break;
            case R.id.key_e_operation:
                if (lastLetterIsCloseBracketOrNumbers()) {
                    keysPressedTv.setText(keysPressedTv.getText() + "xe^");
                } else
                    keysPressedTv.setText(keysPressedTv.getText() + "e^");
                carryOutCalculation();
                break;
            case R.id.key_sqrroot_operation:
                if (lastLetterIsCloseBracketOrNumbers()) {
                    keysPressedTv.setText(keysPressedTv.getText() + "x√");
                } else
                    keysPressedTv.setText(keysPressedTv.getText() + "√");
                break;
            case R.id.key_cuberoot_operation:
                keysPressedTv.setText(keysPressedTv.getText() + "\u221B");
                break;
            case R.id.key_factorial_operation:
                keysPressedTv.setText(keysPressedTv.getText() + "!");
                carryOutCalculation();
                break;
            case R.id.key_cls:
                keysPressedTv.setText("");
                resultTv.setText("0");
                keyDelete.setVisibility(View.VISIBLE);
                keyCls.setVisibility(View.GONE);
                break;
        }
    }
 
 
    public boolean lastLetterIsCloseBracketOrNumbers() {
        String text = keysPressedTv.getText().toString();
        if (text.length() != 0) {
            String last = text.substring(text.length() - 1);
            if (last.equals(")") || last.equals("1") || last.equals("2") || last.equals("3")
                    || last.equals("4") || last.equals("5") || last.equals("6")
                    || last.equals("7") || last.equals("8") || last.equals("9")) {
                return true;
            }
        }
        return false;
    }
 
    public boolean lastLetterIsCloseBracket() {
        String text = keysPressedTv.getText().toString();
        if (text.length() != 0) {
            String last = text.substring(text.length() - 1);
            if (last.equals(")") || last.equals("π") || last.equals("%")) {
                return true;
            }
        }
        return false;
    }
 
    private void operatorClicked(String op) {
        String text = keysPressedTv.getText().toString();
 
        if (text.length() != 0) {
            text += op;
            if (text.charAt(text.lastIndexOf(op) - 1) == 'x' || text.charAt(text.lastIndexOf(op) - 1) == '+' ||
                    text.charAt(text.lastIndexOf(op) - 1) == '÷' || text.charAt(text.lastIndexOf(op) - 1) == '-') {
                text = text.substring(0, text.length() - 2) + op;
            }
            keysPressedTv.setText(text);
            count = 0;
            if (keyCls.getVisibility() == View.VISIBLE && resultTv.getText().toString() != "Error") {
                keysPressedTv.setText(resultTv.getText().toString() + op);
                keyDelete.setVisibility(View.VISIBLE);
                keyCls.setVisibility(View.GONE);
            }
        }
    }
 
    private void deleteKeyClicked() {
 
        text = keysPressedTv.getText().toString();
 
        if (text.length() > 0) {
 
            keyDelete.setVisibility(View.VISIBLE);
            keyCls.setVisibility(View.GONE);
 
            if (text.endsWith(".")) {
                count = 0;
            }
 
            String newText = text;

            if (newText.endsWith("asin(") || newText.endsWith("acos(") || newText.endsWith("atan("))
                newText = newText.substring(0, newText.length() - 5);
 
            else if (newText.endsWith("sin(") || newText.endsWith("cos(") || newText.endsWith("tan(") || newText.endsWith("log("))
                newText = newText.substring(0, newText.length() - 4);
 
            else if (newText.endsWith("ln(") || newText.endsWith("lg("))
                newText = newText.substring(0, newText.length() - 3);
 
            else if (newText.endsWith("e^"))
                newText = newText.substring(0, newText.length() - 2);
 
            else
                newText = text.substring(0, text.length() - 1);
 
            keysPressedTv.setText(newText);
 
            if (newText.isEmpty())
                resultTv.setText("0");
        }
    }
 
    private void carryOutCalculation() {
        expression = keysPressedTv.getText().toString();
 
        if (expression.length() != 0) {
 
            if (expression.contains("\u207B\u00B9")) {
                expression = expression.replace("\u207B\u00B9", "^-1");
            }
 
            if (expression.contains("log")) {
                expression = expression.replace("log(", "log10(");
            }
 
            if (expression.contains("lg")) {
                expression = expression.replace("lg(", "log10(");
            }
 
            if (expression.contains("\u2303")) {
                expression = expression.replaceAll("\u2303", "^");
            }
 
            if (expression.contains("π"))
                expression = expression.replaceAll("π", "pi");
 
            if (expression.endsWith("e^"))
                expression = expression.replace("e^", "e");
 
            if (expression.contains("x")) {
                expression = expression.replaceAll("x", "*");
            }
 
            if (expression.contains("÷")) {
                expression = expression.replaceAll("÷", "/");
            }
 
            if (expression.contains("√")) {
                expression = expression.replaceAll("√", "sqrt(");
            }
 
            if (expression.contains("\u221B")) {
                expression = expression.replaceAll("\u221B", "root(3,");
            }
 
            if (expression.contains("²")) {
                expression = expression.replaceAll("²", "^2");
            }
 
            if (expression.contains("\u00B3")) {
                expression = expression.replaceAll("\u00B3", "^3");
            }
 
            if (expression.contains("sqrt(") || expression.contains("root("))
                expression = returnFormattedString(expression);
 
            if (expression.contains("sin(") || expression.contains("asin(") || expression.contains("cos(")
                    || expression.contains("acos(") || expression.contains("tan(") || expression.contains("atan(")) {
                switch (mRadOrDeg) {
                    case "RAD":
                        expression = formatRadOrDegOperations(expression, "*[rad]");
                        break;
                    case "DEG":
                        expression = formatRadOrDegOperations(expression, "*[deg]");
                        break;
                }
            }
 
            if (expression.contains("(") && !expression.substring(expression.lastIndexOf("("), expression.length()).contains(")")) {
                expression += ")";
            }
 
            Log.d("EQUATION", expression);
 
         
            Expression e1 = new Expression(expression);
            String answer = String.valueOf(e1.calculate());
 
       
            if (answer.equals("NaN"))
                answer = "Error";
 
            resultTv.setText(answer);
        }
    }
 
    public String returnFormattedString(String expression) {
        int last_sign_index = 0;
        char[] signs = {'+', '-', '*', '/'};
        for (int i = 0; i < expression.length(); i++) {
            for (int j = 0; j < signs.length; j++) {
                if (expression.charAt(i) == signs[j]) {
                    String sub_string = expression.substring(last_sign_index, i);
                    if (sub_string.contains("sqrt(") || sub_string.contains("root(")) {
                        String newString = sub_string + ")";
                        expression = expression.replace(sub_string, newString);
                    }
                    last_sign_index = i;
                }
            }
        }
        return expression;
    }
 
    public String formatRadOrDegOperations(String expression, String operation) {
        String[] signs = {"sin(", "asin(", "cos(", "acos(", "tan(", "atan("};
 
        int length = expression.length();
        int last_index = -1;
        String holder = expression;
 
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < signs.length; j++) {
                if (holder.indexOf(signs[j]) == i) {
                    String sub_string = holder.substring(i);
                    if ((sub_string.contains("sin(") || sub_string.contains("asin(") || sub_string.contains("cos(")
                            || sub_string.contains("acos(") || sub_string.contains("tan(") || sub_string.contains("atan("))
                            && i > last_index) {
                        if (sub_string.contains(")")) {
                            String mSub_string = sub_string.substring(0, sub_string.indexOf(")"));
                            expression = expression.replace(mSub_string, mSub_string + operation);
                        } else if (!sub_string.contains(")")) {
                            String mSub_string = sub_string.substring(0);
                            expression = expression.replace(mSub_string, mSub_string + operation);
                        }
                        last_index = i;
                    }
                }
            }
        }
        return expression;
    }
 
 
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}