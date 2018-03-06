namespace java handbook

service HandbookService {
	string changeBody(1: string title, 2: string newBody),
	string deleteReference(1: string title),
	string add(1: string title, 2: string body),
	list<string> takeTitles(),
	string takeBody(1: string title)
}
