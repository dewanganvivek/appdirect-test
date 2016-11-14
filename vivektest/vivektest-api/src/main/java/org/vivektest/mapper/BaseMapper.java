/**
 * 
 */
package org.vivektest.mapper;


/**
 * @author Dewangan
 *
 */
public interface BaseMapper<T, S> {

	public T map(S source);
	
	public S reverseMap(T target);

}
