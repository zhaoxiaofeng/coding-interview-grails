package interview

import com.lerss.ent.api.BlogFacade
import com.lerss.ent.api.BlogEntryDTO
import grails.transaction.Transactional
import interview.BlogEntry

@Transactional
class BlogFacadeService implements BlogFacade {

    @Override
    List<BlogEntryDTO> getRecentEntries(int n) {
        def collDTO = []
        def list = BlogEntry.list(max: n)
        list.each {//仍然没有采用collect方法改写
            collDTO << new BlogEntryDTO(
                    title: it.title,
                    content: it.content,
                    dateCreated: it.dateCreated
            )
        }
        return collDTO
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
