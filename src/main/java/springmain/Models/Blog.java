package springmain.Models;

import javax.persistence.*;

@Entity
@Table(name = "blog")
public class Blog {

  // Primary Key
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column(name = "title")
  private String title;

  @Column(name = "content")
  private String content;

  public Blog() {  }

  public Blog(String title, String content) {
    this.setTitle(title);
    this.setContent(content);
  }

  public Blog(int id, String title, String content) {
    this.setId(id);
    this.setTitle(title);
    this.setContent(content);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  @Override
  public String toString() {
    return "Blog{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", content='" + content + '\'' +
            '}';
  }
}
