package interview

class BlogEntry {
    String title
    String content
    Date createdDate//dateCreated 字段在数据第一次插入到数据库时被填充，故和我们设置的时间不同，测试不通过
}
