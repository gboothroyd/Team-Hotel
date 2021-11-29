/**
 * @author Elizabeth Allen - eallen12
 * CIS175 - Fall 2021
 * Nov 28, 2021
 */
package dmacc.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import dmacc.beans.Room;

@Service
public interface RoomService {
    List < Room > getAllRooms();
    void saveRoom(Room room);
    Room getRoomById(long id);
    void deleteRoomById(long id);
    
    Page<Room> findRoomPaginated(int pageNo, int pageSize, String sortField, String sortDirect);
}
