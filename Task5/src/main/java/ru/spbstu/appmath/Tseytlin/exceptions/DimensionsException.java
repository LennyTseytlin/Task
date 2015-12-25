package ru.spbstu.appmath.Tseytlin.exceptions;

/**
 * Created by admin on 25/12/15.
 */
public class DimensionsException extends MatrixCalcException{
    public DimensionsException() {
        super("File doesn't contain valid data");
    }
}
