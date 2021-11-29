/**
 * @author Elizabeth Allen - eallen12
 * CIS175 - Fall 2021
 * Nov 28, 2021
 */
package dmacc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import dmacc.beans.Room;
import dmacc.repository.RoomRepository;

@Service
public class RoomServiceImpl implements RoomService {
	@Autowired
	private RoomRepository roomRepo;
	
	@Override
	public List<Room> getAllRooms() {
		return roomRepo.findAll();
	}

	@Override
	public void saveRoom(Room room) {
		this.roomRepo.save(room);
	}

	@Override
	public Room getRoomById(long id) {
		Optional<Room> optional = roomRepo.findById(id);
		Room room = null;
		if (optional.isPresent()) {
			room = optional.get();
		} else {
			throw new RuntimeException(" Room not found for id : " + id);
		}
		return room;
	}

	@Override
	public void deleteRoomById(long id) {
		this.roomRepo.deleteById(id);
	}
	
	@Override
	public Page<Room> findRoomPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.roomRepo.findAll(pageable);
	}
}
