package com.springstarter.f06_mybatis.typehandlers;

public enum UserState {
    DISABLED(0),
    AVAILABLE(1);

    private final int status;

    UserState(int status){
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public static UserState fromValue(int value){
        for (UserState userState:UserState.values()){
            if (userState.status==value) return userState;
        }
        throw new IllegalArgumentException("Cannot create evalue from value:"+value+"!");
    }

}
