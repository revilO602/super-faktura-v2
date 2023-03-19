/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author leont
 */
public class MissingDataException extends RuntimeException{
    public MissingDataException(String errorMessage) {
        super(errorMessage);
    }
}
