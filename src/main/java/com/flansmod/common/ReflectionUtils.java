package com.flansmod.common;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.client.renderer.entity.RenderLivingBase;

public class ReflectionUtils
{

    public static <T> List<Class<? extends T>> getSuperClasses(@Nonnull Class<? extends T> startClass, @Nullable Class<? extends T> exclusiveParent)
    {
        if (exclusiveParent != null && !exclusiveParent.isAssignableFrom(startClass))
        {
            //the parent is not a superclass of the startClass. continue until Object.class.
            exclusiveParent = null;
        }
        List<Class<? extends T>> result = getSuperClassesRecursive(startClass, exclusiveParent);
        return result;
    }

    @SuppressWarnings("unchecked")
    private static <T> List<Class<? extends T>> getSuperClassesRecursive(@Nonnull Class<? extends T> startClass, @Nullable Class<? extends T> exclusiveParent)
    {
        List<Class<? extends T>> currentList = new ArrayList<Class<? extends T>>();
        currentList.add(startClass);
        Class<?> currentParent = startClass.getSuperclass();
        if (currentParent != null)
        {
            //if there is no exclusiveParent is specified, continue until Object.class.
            // if the exclusive parent and the current parent are not both an interface, it's enough if the current parent extends the exclusive parent,
            // since the current parent can never equal the exclusive parent (super() of a class that implements "something" returns the extended class (Object.class if nothing is extended) and not the interface "something").
            // If they are both an interface or both not an interface, they must be unequal for this to continue. If they are equal, we've reached the exclusive parent and can stop collecting classes.
            if (exclusiveParent == null || (exclusiveParent.isInterface() != currentParent.isInterface() ? exclusiveParent.isAssignableFrom(currentParent) : !exclusiveParent.equals(currentParent)))
            {
                currentList.addAll(getSuperClassesRecursive((Class<? extends T>) currentParent, exclusiveParent));
            }
        }
        return currentList;
    }


    private static HashMap<Class, HashMap<String, List<String>>> obfuscatedFieldNames = new HashMap<Class, HashMap<String, List<String>>>();
    private static HashMap<Class, HashMap<String, Field>> fieldMap = new HashMap<Class, HashMap<String, Field>>();


    private static void setObfuscatedName(Class cls, String nonObfuscatedName, String... names)
    {
        HashMap<String, List<String>> classFields =  obfuscatedFieldNames.get(cls);
        if (classFields == null)
        {
            classFields = new HashMap<>();
            obfuscatedFieldNames.put(cls, classFields);
        }
        classFields.put(nonObfuscatedName, Arrays.asList(names));
    }
    static
    {
        setObfuscatedName(RenderLivingBase.class, "layerRenderers", "field_177097_h");
    }

    private static Field getObfuscatedField(Class<?> clazz, String nonObfuscated) throws NoSuchFieldException
    {
        HashMap<String, Field> classFields = fieldMap.get(clazz);
        if (classFields == null)
        {
            classFields = new HashMap<String, Field>();
            fieldMap.put(clazz, classFields);
        }
        Field result = classFields.get(nonObfuscated);
        if (result == null)
        {

            try
            {
                //try to find it by normal name.
                result = clazz.getDeclaredField(nonObfuscated);
            }
            catch (NoSuchFieldException e1)
            {
                //try to find it with obfuscated name
                Map<String, List<String>> obfuscatedAdapter = obfuscatedFieldNames.get(clazz);
                if (obfuscatedAdapter == null)
                {
                    throw new NullPointerException(String.format("No obfuscated names were specified for field %s in " +
                            "class %s.", nonObfuscated, clazz));
                }
                for (String obfuscated : obfuscatedAdapter.get(nonObfuscated))
                {
                    try
                    {
                        result = clazz.getDeclaredField(obfuscated);
                        break;
                    }
                    catch (NoSuchFieldException e)
                    {
                    }
                }
                if (result == null)
                {
                    List<String> obfuscatedNames = obfuscatedAdapter.get(nonObfuscated);
                    throw new NoSuchFieldError(String.format("Field with nonObfuscated name '%s' could not be found in " +
                                    "class %s! Provided obfuscated names for this field : %s.", nonObfuscated, clazz,
                            obfuscatedNames.size() == 0 ? "none" : obfuscatedNames));
                }
            }
            classFields.put(nonObfuscated, result);
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    public static <T, E> T getValue(Class<? super E> classToAccess, E instance, String fieldName)
    {
        try
        {
            Field field = getObfuscatedField(classToAccess, fieldName);
            field.setAccessible(true);
            return (T) field.get(instance);
        }
        catch (Exception e)
        {
            throw new RuntimeException(String.format("Exception while trying to get value of field '%s' from '%s' " +
                    "(class: %s)", fieldName, instance, classToAccess), e);
        }
    }

    public static <E> void setValue(Class<? super E> classToAccess, E instance, String fieldName, Object value)
    {
        try
        {
            Field field = getObfuscatedField(classToAccess, fieldName);
            field.setAccessible(true);
            field.set(instance, value);
        }
        catch (Exception e)
        {
            throw new RuntimeException(String.format("Exception while trying to set value of field '%s' to '%s' " +
                    "(class: %s)", fieldName, value, classToAccess), e);
        }
    }

}
