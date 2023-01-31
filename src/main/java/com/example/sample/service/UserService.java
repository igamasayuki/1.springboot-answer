package com.example.sample.service;

import org.springframework.stereotype.Service;

import com.example.sample.domain.User;

/**
 * ユーザ情報登録処理を行うサービスクラス.
 * 
 * @author igamasayuki
 */
@Service
public class UserService {

	public User save(User user) {
		// (1)本来ならここでUserRepositoryを呼んでDBにインサートをする
		// UserRepository repository = new UserRepository();
		// user = repository.insert(user);

		// (2)趣味を登録するなど、他にもDBにインサートする必要があれば
		// ここに記載する

		// (3)更に、登録完了メールを送る場合はここに記載する

		return user;
	}

}
