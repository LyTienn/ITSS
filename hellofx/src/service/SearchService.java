package service;
import model.Media;
import java.util.List;
import java.util.stream.Collectors;

public class SearchService {
	//Tìm kiếm theo danh mục
	public static List<Media> searchMediaByCategory(List<Media> mediaList, String keyword) {
		return mediaList.stream()
			.filter(media -> media.getCategory().toLowerCase().contains(keyword.toLowerCase()) )
			.collect(Collectors.toList());
	}
	
	public static List<Media> searchMediaByTitle(List<Media> mediaList, String keyword) {
		return mediaList.stream()
			.filter(media -> media.getTitle().toLowerCase().contains(keyword.toLowerCase()) )
			.collect(Collectors.toList());
	}
	
}


