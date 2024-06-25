package com.cloudicia.java22.ffmApi;

import java.lang.foreign.*;
import java.lang.invoke.*;

public class FfmApi {
    public static void main(String[] args) throws Throwable {
        strLengthMethod("Manoj");
        strPrintFMethod("Test");
    }

    private static void strLengthMethod(String text) throws Throwable {
        // STEP 1: FIND FOREIGN FUNCTION
        Linker linker = Linker.nativeLinker();
        SymbolLookup stdlib = linker.defaultLookup();
        MemorySegment strlenAddress = stdlib.find("strlen").orElseThrow();

        // STEP 2: DEFINE IN/OUT AND CREATE METHOD HANDLE
        FunctionDescriptor descriptor = FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS);
        MethodHandle strlen = linker.downcallHandle(strlenAddress, descriptor);

        // STEP 3: MANAGE OFF-HEAP MEMORY
        try (Arena offHeap = Arena.ofConfined()) {
            // STEP 4: MAKE ARGUMENT C-COMPATIBLE IN OFF-HEAP MEMORY
            MemorySegment funcArg = offHeap.allocateFrom(text);

            // STEP 5: CALL THE FUNCTION
            long len = (long) strlen.invoke(funcArg);
            System.out.println(len);
        }
    }

    private static void strPrintFMethod(String text) throws Throwable {
        // STEP 1: FIND FOREIGN FUNCTION
        Linker linker = Linker.nativeLinker();
        SymbolLookup stdlib = linker.defaultLookup();
        MemorySegment strlenAddress = stdlib.find("printf").orElseThrow();

        // STEP 2: DEFINE IN/OUT AND CREATE METHOD HANDLE
        FunctionDescriptor descriptor = FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS);
        MethodHandle strlen = linker.downcallHandle(strlenAddress, descriptor);

        // STEP 3: MANAGE OFF-HEAP MEMORY
        try (Arena offHeap = Arena.ofConfined()) {
            // STEP 4: MAKE ARGUMENT C-COMPATIBLE IN OFF-HEAP MEMORY
            MemorySegment funcArg = offHeap.allocateFrom(text);

            // STEP 5: CALL THE FUNCTION
            strlen.invoke(funcArg);
        }
    }
}
