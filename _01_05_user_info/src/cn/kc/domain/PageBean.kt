package cn.kc.domain

/**
 * 分页对象
 */
class PageBean<T> {
    var totalCount: Int = 0 // 总记录数
    var totalPage: Int = 0 // 总页码
    var list: List<T>? = null // 每页的数据
    var currentPage: Int = 0 //当前页码
    var rows: Int = 0//每页显示的记录数

    override fun toString(): String {
        return "PageBean{" +
                "totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", list=" + list +
                ", currentPage=" + currentPage +
                ", rows=" + rows +
                '}'.toString()
    }
}
