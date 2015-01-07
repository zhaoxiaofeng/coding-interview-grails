package interview

import com.lerss.ent.api.BlogFacade
import com.lerss.ent.api.BlogEntryDTO
import grails.transaction.Transactional
import interview.BlogEntry

@Transactional
class BlogFacadeService implements BlogFacade {

	@Override
	List<BlogEntryDTO> getRecentEntries(int n){//不正确的缩进
		List<BlogEntryDTO> listDTO=new ArrayList<BlogEntryDTO>()
		List<BlogEntry> list=BlogEntry.list(max:n)
		for(blogEntry in list){//使用groovy风格的代码
			listDTO.add(new BlogEntryDTO(
				title: blogEntry.title,
				content: blogEntry.content,
				dateCreated: blogEntry.createdDate
			))
		}
	return listDTO
	}
     
    @Override
	void publish(BlogEntryDTO entry){
		new BlogEntry(
			title: entry.title,
			content: entry.content,
			createdDate: entry.dateCreated
		).save()
	}
}
