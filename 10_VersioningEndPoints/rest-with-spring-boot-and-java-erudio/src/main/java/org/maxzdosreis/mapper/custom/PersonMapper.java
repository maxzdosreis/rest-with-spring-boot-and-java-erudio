package org.maxzdosreis.mapper.custom;

import java.util.Date;

import org.maxzdosreis.data.vo.v2.PersonVOV2;
import org.maxzdosreis.model.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonMapper {
	public PersonVOV2 convertEntityToVo(Person person) {
		PersonVOV2 vo = new PersonVOV2();
		vo.setId(person.getId());
		vo.setFirstName(person.getFirstName());
		vo.setLastName(person.getLastName());
		vo.setAddress(person.getAddress());
		vo.setGender(person.getGender());
		vo.setBirthDay(new Date());
		return vo;
	}
	
	public Person convertVoToEntity(PersonVOV2 vo) {
		Person person = new Person();
		person.setId(vo.getId());
		person.setFirstName(vo.getFirstName());
		person.setLastName(vo.getLastName());
		person.setAddress(vo.getAddress());
		person.setGender(vo.getGender());
		return person;
	}
}
