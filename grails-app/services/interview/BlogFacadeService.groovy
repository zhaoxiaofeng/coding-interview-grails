package interview

import com.lerss.ent.api.BlogFacade
import com.lerss.ent.api.BlogEntryDTO
import grails.transaction.Transactional
import interview.BlogEntry

@Transactional
class BlogFacadeService implements BlogFacade {

    @Override
    List<BlogEntryDTO> getRecentEntries(int n) {
        List<BlogEntryDTO> listDTO = new ArrayList<BlogEntryDTO>()
        List<BlogEntry> list = BlogEntry.list(max: n)
        list.each {
            listDTO.add(new BlogEntryDTO(
                    title: it.title,
                    content: it.content,
                    dateCreated: it.dateCreated
            ))
        }
        return listDTO//采用Groovy风格改写，使用collect方法改写
    }

    @Override
    void publish(BlogEntryDTO entry) {
        new BlogEntry(
                title: entry.title,
                content: entry.content,
                dateCreated: entry.dateCreated
        ).save()
    }
}
