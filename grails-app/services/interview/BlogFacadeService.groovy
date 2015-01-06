package interview

import com.lerss.ent.api.BlogFacade
import com.lerss.ent.api.BlogEntryDTO
import grails.transaction.Transactional
import interview.Blog

@Transactional
class BlogFacadeService implements BlogFacade {

    @Override
     List<BlogEntryDTO> getRecentEntries(int n){//不正确的缩进
     List<BlogEntryDTO> listDTO=new ArrayList<BlogEntryDTO>();
     List<Blog> list=Blog.list(max:n);
     for(Blog blog:list){//使用groovy风格的代码
     listDTO.add(new BlogEntryDTO(
                title: blog.title,
                content: blog.content,
                dateCreated: blog.dateCreatedx
        )
     
     );
     }
     return listDTO;
     }
     
    @Override
      void publish(BlogEntryDTO entry){
      new Blog(
                title: entry.title,
                content: entry.content,
                dateCreatedx: entry.dateCreated
        ).save();
      }
}
