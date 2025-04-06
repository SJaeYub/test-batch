package com.demo.testbatch.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public enum ServicePolicy {
    A(1L, "fastcampus.services/a", 10),
    B(1L, "fastcampus.services/b", 10),
    C(1L, "fastcampus.services/c", 10),
    D(1L, "fastcampus.services/d", 10),
    E(1L, "fastcampus.services/e", 10),
    F(1L, "fastcampus.services/f", 10),
    G(1L, "fastcampus.services/g", 10),
    H(1L, "fastcampus.services/h", 10),
    I(1L, "fastcampus.services/i", 10),
    J(1L, "fastcampus.services/j", 10),
    K(1L, "fastcampus.services/k", 10),
    L(1L, "fastcampus.services/l", 10),
    M(1L, "fastcampus.services/m", 10),
    N(1L, "fastcampus.services/n", 10),
    O(1L, "fastcampus.services/o", 12),
    P(1L, "fastcampus.services/p", 10),
    Q(1L, "fastcampus.services/q", 10),
    R(1L, "fastcampus.services/r", 1),
    S(1L, "fastcampus.services/s", 10),
    T(1L, "fastcampus.services/t", 10),
    U(1L, "fastcampus.services/u", 10),
    V(1L, "fastcampus.services/v", 10),
    W(1L, "fastcampus.services/w", 15),
    X(1L, "fastcampus.services/x", 12),
    Y(1L, "fastcampus.services/y", 14),
    Z(1L, "fastcampus.services/z", 12);


    private final Long id;
    private final String url;
    private final Integer fee;

    ServicePolicy(Long id, String url, Integer fee) {
        this.id = id;
        this.url = url;
        this.fee = fee;
    }
}
