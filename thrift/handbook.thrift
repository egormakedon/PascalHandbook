namespace java rpcserver.thrift

struct Image {
  1: i32 imageId,
  2: string path
}

struct Author {
  1: i32 authorId,
  2: string name,
  3: string surname,
  4: string country
}

struct Date {
  1: i32 day,
  2: i32 month,
  3: i32 year
}

struct Article {
  1: i32 articleId,
  2: string title,
  3: string body,
  4: Date date,
  5: Image image,
  6: Author author
}

service HandbookService {
	string updateArticle(1: Article article),
	string deleteArticle(1: Article article),
	string add(1: Article article),
	list<Article> takeArticleList(),
	Article takeArticle(1: string title)
}
