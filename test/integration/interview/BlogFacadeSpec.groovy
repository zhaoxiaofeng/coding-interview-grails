package interview

import com.lerss.ent.api.BlogEntryDTO
import com.lerss.ent.api.BlogFacade
import spock.lang.Specification

class BlogFacadeSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    // This is injected by grails convention
    BlogFacade blogFacadeService

    void "newly published blog should at top of recent blog entries"() {
        given:
        blogFacadeService.publish(new BlogEntryDTO(
                title: 'title',
                content: 'content',
        ))
        def entry = blogFacadeService.getRecentEntries(1)[0]

        expect:
        entry.title == 'title'
        entry.content == 'content'
        entry.dateCreated != null
    }
}
