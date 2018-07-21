package com.bookmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmanagement.dao.BookDao;
import com.bookmanagement.dao.LibraryDao;
import com.bookmanagement.dao.UserDao;
import com.bookmanagement.model.Library;
import com.bookmanagement.model.User;
import com.bookmanagement.utility.ApplicationConstants;
import com.bookmanagement.utility.DateUtility;
import com.bookmanagement.vo.LibraryVo;
@Service
public class LibraryServiceImpl implements LibraryService {
	
	@Autowired
	private LibraryDao libraryDao;
	@Autowired
	private BookDao bookDao;
	@Autowired
	private UserDao userDao;
	
	@Override
	public List<LibraryVo> getLibraries(Long userId) {
		List<Library> libraryList = libraryDao.getLibraries(userId);
		List<LibraryVo> libraryVoLst = new ArrayList<LibraryVo>();
		if(libraryList!= null) {
			for (Library library : libraryList) {
				LibraryVo libraryVo = new LibraryVo();
				libraryVo.setLibraryId(library.getLibraryId());
				libraryVo.setUserId(library.getUser().getUserId());
				libraryVo.setLibraryName(library.getName());
				libraryVoLst.add(libraryVo);
			}
		}
		return libraryVoLst;
	}

	@Override
	public LibraryVo getLibraryById(Long libraryId) {
		Library library = libraryDao.getLibraryById(libraryId);
		if(library!=null) {
			LibraryVo libraryVo = new LibraryVo();
			libraryVo.setLibraryId(library.getLibraryId());
			libraryVo.setUserId(library.getUser().getUserId());
			libraryVo.setLibraryName(library.getName());
			return libraryVo;
		}
		return null;
	}

	@Override
	public Long addLibrary(LibraryVo libraryVo) {
		try {
			User user = userDao.getUserById(libraryVo.getUserId());
			Library library = new Library();
			if(user!=null) {
				library.setUser(user);
			}else {
				throw new Exception("User not found");
			}
			library.setName(libraryVo.getLibraryName());
			library.setCreatedDate(DateUtility.getCurrentDate());
			library.setIsActive(ApplicationConstants.IS_ACTIVE);
			
			return libraryDao.createLibrary(library);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public LibraryVo updateLibrary(LibraryVo libraryVo) {
		try {
			Library library = new Library();
			library.setLibraryId(libraryVo.getLibraryId());
			library.setName(libraryVo.getLibraryName());
			libraryDao.updateLibrary(library);
			return libraryVo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteLibrary(Long libraryId) {
		libraryDao.deleteLibrary(libraryId);
	}

}
