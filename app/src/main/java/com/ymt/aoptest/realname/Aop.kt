package com.ymt.aoptest.realname

import android.util.Log
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.aspectj.lang.reflect.MethodSignature

@Aspect
open class Aop {

    @Pointcut("execution(@com.ymt.aoptest.realname.RealNameCheck * *(..))")
    public fun realNameCheck() {

    }

    @Around("realNameCheck()")
    @Throws(Throwable::class)
    public fun aroundRealNameCheck(point: ProceedingJoinPoint) {
        val method = (point.signature as? MethodSignature)?.method ?: return
        if (method.isAnnotationPresent(RealNameCheck::class.java)) {
            if (TouristUtils.hasRealName()) {
                point.proceed()
            }else{
                Log.d("tag","需要去实名")
            }
        }
    }

}