package com.hyd.smart.mylibrary.Demos;

import java.util.HashMap;

public class HashMapMain {

    public static void main(String[] args){
        HashMap<String,String> hashMap=new HashMap<String,String>();
        hashMap.put("wangsadasshaoli1","王少丽");
        hashMap.put("wangfhgfhshaoli2","王少丽");
        hashMap.put("wangshrwetaoli3","王少丽");
        hashMap.put("wangshyuiyaoli4","王少丽");
        for (HashMap.Entry<String,String> entry: hashMap.entrySet()){
            System.out.println(entry.getKey()+",value="+entry.getValue());

        }
    }
}
