package com.xzinoviou.ssec.mapper;

public interface GenericMapper<E, V> {

    V mapToDto(E e);

    E convertToEntity(V v);
}
