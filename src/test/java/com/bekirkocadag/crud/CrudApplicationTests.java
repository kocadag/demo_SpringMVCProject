package com.bekirkocadag.crud;

import com.bekirkocadag.crud.dtos.LibraryRequest;
import com.bekirkocadag.crud.models.LibraryModel;
import com.bekirkocadag.crud.repositories.LibraryRepository;
import com.bekirkocadag.crud.services.LibraryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class CrudApplicationTests {

	@Test
	public void test1() {
		System.out.println("Bekir");
		//  create mock
		LibraryService test = mock(LibraryService.class);

		// define return value for method getUniqueId()
		LibraryModel tmp = new LibraryModel();
		tmp.setBookName("Hacı Bekir Book Name");
		tmp.setWriterName("Kocadag Wrıter Name");

		when(test.findById(12L)).thenReturn(tmp);

		// use mock in test....
		assertEquals(test.findById(12L), tmp);
	}

}
