package interview

import com.lerss.ent.api.BlogFacade
import com.lerss.ent.api.BlogEntryDTO
import grails.transaction.Transactional
import interview.BlogEntry

@Transactional
class BlogFacadeService implements BlogFacade {

	@Override
	List<BlogEntryDTO> getRecentEntries(int n){//不正确的缩进//修正的评审注释需要去掉//大括号前需要有空格
		List<BlogEntryDTO> listDTO=new ArrayList<BlogEntryDTO>()//等号前后需要有空格
		List<BlogEntry> list=BlogEntry.list(max:n)
		for(blogEntry in list){//使用groovy风格的代码//使用groovy的.each{}风格重写
			listDTO.add(new BlogEntryDTO(
				title: blogEntry.title,
				content: blogEntry.content,
				dateCreated: blogEntry.createdDate
			))
		}
	return listDTO//使用groovy风格的代码
	}
     //不一致的缩进
    @Override
	void publish(BlogEntryDTO entry){
		new BlogEntry(
			title: entry.title,
			content: entry.content,
			createdDate: entry.dateCreated
		).save()
	}
}
