package kg.ticode.zukhridin_safarbek.phonemasker

enum class MaskStyle {

    NORMAL,
    COMPLETABLE,
    PERSISTENT;

    companion object {

        fun valueOf(ordinal: Int): MaskStyle = values().find { it.ordinal == ordinal } ?: NORMAL
    }
}