package net.unit8.sigcolle.validator;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * パスワードの入力チェック.
 * <ul>
 *     <li>数字</li>
 *     <li>大文字アルファベット</li>
 *     <li>小文字アルファベット</li>
 *     <li>記号</li>
 * </ul>
 * がすべて1つ以上入っていないといけない.
 */
public class PasswordValidator implements ConstraintValidator<Password, String> {
    @Override
    public void initialize(Password password) {
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null || s.isEmpty()) {
            return true;
        }

        return Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$")
                .matcher(s)
                .matches();
    }
}
