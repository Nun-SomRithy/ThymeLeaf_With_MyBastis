package co.istad.thymeleaf.webapp.repository;


import co.istad.thymeleaf.webapp.model.Article;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Mapper
@Repository
public interface ArticleRepository {
    @Insert("INSERT  INTO  articles (uuid,title,thumbnail,author) " +
            "VALUES(#{a.uuid},#{a.title},#{a.thumbnail},#{a.author})")
    void insert(@Param("a") Article article);
    @Select("SELECT * FROM  articles ORDER BY  title DESC")
    @Result(column = "uuid",property = "uuid")
    List<Article> select();


    @Select("SELECT * FROM articles WHERE uuid= #{uuid}")
    Article selectByUuid(String uuid);

//    @Delete("DELETE FROM articles WHERE  uuid=#{uuid}")
//    void deleteByUuid(String uuid);

//    @Update("""
//            UPDATE articles
//            SET title = #{a.title} = #{a.thumbnail},
//            author= #{a.author}
//            WHERE uuid= #{a.uuid}
//            """)


}
