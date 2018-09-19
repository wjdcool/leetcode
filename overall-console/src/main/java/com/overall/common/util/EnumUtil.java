package com.overall.common.util;

import com.overall.common.data.GetEnumOutData;
import com.overall.common.enums.EnumType;
import com.overall.common.enums.ParameterCode;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class EnumUtil {

    /**
     * 获取value返回枚举对象
     *
     * @param value
     * @param clazz
     */
    @SuppressWarnings("unchecked")
    public static <T extends EnumType> T getEnumObject(int value, Class<T> clazz) throws Exception {
        return (T) initialEnumMap(clazz).get(value);
    }

    /**
     * 根据label获取value
     * @author yq
     * @date 2018/9/11
     */
    public static Integer getEnumValue(String label, Class<?> clazz) throws Exception {
        List<GetEnumOutData> list = getEnumAll(clazz);
        Integer value = null;
        for (GetEnumOutData outData : list) {
            if (label.equals(outData.getLabel())) {
                value = outData.getValue();
                break;
            }
        }
        return value;
    }

    /**
     * 获取枚举集合
     *
     * @author yq
     * @date 2018/9/4
     */
    public static List<GetEnumOutData> getEnumAll(String className) throws Exception {
        Class<?> clazz = Class.forName(ParameterCode.ENUM_PACKAGE_NAME.getCode() + "." + className);
        return getEnumAll(clazz);
    }

    /**
     * 获取枚举集合
     *
     * @author yq
     * @date 2018/9/4
     */
    public static List<GetEnumOutData> getEnumAll(Class<?> clazz) throws Exception {
        List<GetEnumOutData> list = new ArrayList<>();
        Map<Integer, EnumType> map = initialEnumMap(clazz);
        for (Map.Entry<Integer, EnumType> entry : map.entrySet()) {
            EnumType enumType = entry.getValue();
            list.add(new GetEnumOutData(enumType.getValue(), enumType.getLabel()));
        }
        return list;
    }

    /**
     * 加载所有枚举对象数据
     */
    private static Map<Integer, EnumType> initialEnumMap(Class<?> cls) throws Exception {
        Map<Integer, EnumType> ENUM_MAP = new LinkedHashMap<>();
        Method method = cls.getMethod("values");
        EnumType inter[] = (EnumType[]) method.invoke(null, null);
        for (EnumType enumMessage : inter) {
            ENUM_MAP.put(enumMessage.getValue(), enumMessage);
        }
        return ENUM_MAP;
    }

}
