package ssafy.readed.domain.report.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ssafy.readed.domain.book.entity.Book;
import ssafy.readed.domain.member.entity.Member;
import ssafy.readed.global.entity.BaseEntity;

@Entity
@Getter
@NoArgsConstructor
public class Report extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(name = "report_title")
    private String reportTitle;

    @Column(name = "report_content", columnDefinition = "TEXT")
    private String reportContent;

    private Boolean isPublic;

    @Builder
    public Report(Long id, Member member, Book book, String reportTitle, String reportContent,
            Boolean isPublic) {
        this.id = id;
        this.member = member;
        this.book = book;
        this.reportTitle = reportTitle;
        this.reportContent = reportContent;
        this.isPublic = isPublic;
    }
}
