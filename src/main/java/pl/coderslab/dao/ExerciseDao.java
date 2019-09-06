package pl.coderslab.dao;




import pl.coderslab.DbUtil;
import pl.coderslab.model.Exercise;
import pl.coderslab.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExerciseDao {

    private static final String INSERT_STRING = "Insert INTO exercises(title,description) values (?,?)";
    private static final String DELETE_STRING = "DELETE FROM exercises WHERE id =?";
    private static final String SELECT_STRING = "SELECT id,title,description FROM exercises";
    private static final String UPDATE_STRING = "UPDATE exercises SET  title = ?,description = ?   WHERE id= ?";

    public Exercise create(Exercise exercise) {

        try {
            final Connection connection = DbUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STRING, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, exercise.getTitle());
            preparedStatement.setString(2, exercise.getDescription());
            preparedStatement.executeUpdate();
            final ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            while (generatedKeys.next()) {
                final int idOfInsertedUser = generatedKeys.getInt(1);
                exercise.setId(idOfInsertedUser);
            }
            return exercise;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Exercise> findAll() {

        final Connection connection;
        try {
            connection = DbUtil.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id,title,description FROM exercises");
            return ResulTSetToUserList(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }


    }

    private List<Exercise> ResulTSetToUserList(ResultSet resultSet) {
        List<Exercise> exercises = new ArrayList<>();
        while (true) {
            try {
                if (!resultSet.next()) break;

                final int id = resultSet.getInt("id");
                final String title = resultSet.getString("title");
                final String description = resultSet.getString("description");

                Exercise newExercise = new Exercise(id, title, description);
                exercises.add(newExercise);
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }

        }
        return exercises;
    }

    public int delete(Exercise exercise) {
        final Connection connection;
        try {
            connection = DbUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STRING);
            preparedStatement.setInt(1, exercise.getId());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }

    }

    public Exercise read(int exerciseId) {
        try {

            final Connection connection = DbUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STRING);
            ResultSet resultSet = preparedStatement.executeQuery();
            Exercise exercise = new Exercise();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                if (id == exerciseId) {
                    exercise.setId(id);
                    exercise.setTitle(title);
                    exercise.setDescription(description);
                    return exercise;
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public void update(Exercise exercise) {
        final Connection connection;
        try {
            connection = DbUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STRING);
            preparedStatement.setString(1, exercise.getTitle());
            preparedStatement.setString(2, exercise.getDescription());
            preparedStatement.setInt(3, exercise.getId());
            int numberOfUpdatedItems = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


}
