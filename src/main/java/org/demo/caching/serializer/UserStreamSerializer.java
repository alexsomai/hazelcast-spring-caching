package org.demo.caching.serializer;

import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.StreamSerializer;
import org.demo.caching.model.User;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author Alexandru Somai
 *         date 7/11/2015
 */
@Component
public class UserStreamSerializer implements StreamSerializer<User> {

    @Override
    public void write(ObjectDataOutput out, User user) throws IOException {
        out.writeLong(user.getId());
        out.writeUTF(user.getEmail());
        out.writeUTF(user.getUsername());
        out.writeUTF(user.getFirstName());
        out.writeUTF(user.getLastName());
        out.writeBoolean(user.getIsActive());
    }

    @Override
    public User read(ObjectDataInput in) throws IOException {
        User user = new User();

        user.setId(in.readLong());
        user.setEmail(in.readUTF());
        user.setUsername(in.readUTF());
        user.setFirstName(in.readUTF());
        user.setLastName(in.readUTF());
        user.setIsActive(in.readBoolean());

        return user;
    }

    @Override
    public int getTypeId() {
        return 1;
    }

    @Override
    public void destroy() {

    }

}
