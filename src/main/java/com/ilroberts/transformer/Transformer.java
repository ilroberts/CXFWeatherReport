package com.ilroberts.transformer;

/**
 * Created by iwan on 16/07/2017.
 */
public interface Transformer<T, C> {

    C transform(T opigin);

}
