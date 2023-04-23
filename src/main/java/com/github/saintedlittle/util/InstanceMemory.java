package com.github.saintedlittle.util;

import com.github.saintedlittle.BanInformator;
import lombok.Getter;

import java.util.concurrent.atomic.AtomicReference;

@Getter
public final class InstanceMemory {

    public static final AtomicReference<BanInformator> instance = new AtomicReference<BanInformator>();

}
