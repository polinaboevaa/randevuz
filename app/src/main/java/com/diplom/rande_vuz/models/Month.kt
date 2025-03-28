package com.diplom.rande_vuz.models

enum class Month(val displayName: String) {
    JANUARY("январь"),
    FEBRUARY("февраль"),
    MARCH("март"),
    APRIL("апрель"),
    MAY("май"),
    JUNE("июнь"),
    JULY("июль"),
    AUGUST("август"),
    SEPTEMBER("сентябрь"),
    OCTOBER("октябрь"),
    NOVEMBER("ноябрь"),
    DECEMBER("декабрь");

    companion object {
        fun fromInt(value: Int): Month {
            return values().getOrElse(value - 1) { JANUARY }
        }
    }
}