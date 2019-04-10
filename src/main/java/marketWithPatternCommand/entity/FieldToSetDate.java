package marketWithPatternCommand.entity;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Указывает, что наша Аннотация может использована во время выполнения
// через Reflection (нам как раз это нужно).
@Retention(RetentionPolicy.RUNTIME)

// Указывает, что целью нашей Аннотации является поле
// (не класс, не переменная, не метод, а именно поле).
@Target(ElementType.FIELD)
public @interface FieldToSetDate {
    //  1 - дата поставки,
    //  2 - дата окончания срока годности
    int dateType();
}