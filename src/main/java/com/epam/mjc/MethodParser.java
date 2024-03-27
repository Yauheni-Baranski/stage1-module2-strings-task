package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     * 1. access modifier - optional, followed by space: ' '
     * 2. return type - followed by space: ' '
     * 3. method name
     * 4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     * accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     * private void log(String value)
     * Vector3 distort(int x, int y, int z, float magnitude)
     * public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {
        String[] parts = signatureString.split("\\(", 2);
        String[] methodSignatureParts = parts[0].trim().split(" ");
        String accessModifier = null;
        String returnType;
        String methodName;

        if (methodSignatureParts.length == 3) {
            accessModifier = methodSignatureParts[0];
            returnType = methodSignatureParts[1];
            methodName = methodSignatureParts[2];
        } else {
            returnType = methodSignatureParts[0];
            methodName = methodSignatureParts[1];
        }

        String methodArguments = parts[1].replace(")", "").trim();
        List<MethodSignature.Argument> arguments = new ArrayList<>();
        if (!methodArguments.isEmpty()) {
            String[] argumentPairs = methodArguments.split(",");
            for (String el : argumentPairs) {
                String[] argumentParts = el.trim().split(" ");
                arguments.add(new MethodSignature.Argument(argumentParts[0], argumentParts[1]));
            }
        }

        MethodSignature methodSignature = new MethodSignature(methodName, arguments);
        methodSignature.setAccessModifier(accessModifier);
        methodSignature.setReturnType(returnType);

        return methodSignature;
    }
}