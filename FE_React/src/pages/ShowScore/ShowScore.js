function ShowScore() {
  return (
    <table class="table">
      <thead>
        <tr>
          <th scope="col">ID</th>
          <th scope="col">Name</th>
          <th scope="col">Quiz</th>
          <th scope="col">Mark</th>
          <th scope="col">Date</th>
          <th scope="col">Handle</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <th scope="row">1</th>
          <td>Mark</td>
          <td>Beginer</td>
          <td>9</td>
          <td>10/9/2022</td>
          <td>
            <button type="button" class="btn btn-primary">
              Feedback
            </button>
          </td>
        </tr>
        <tr>
          <th scope="row">2</th>
          <td>Jacob</td>
          <td>Beginer</td>
          <td>10</td>
          <td>10/9/2022</td>
          <td>
            <button type="button" class="btn btn-primary">
              Feedback
            </button>
          </td>
        </tr>
        <tr>
          <th scope="row">3</th>
          <td>Larry</td>
          <td>Beginer</td>
          <td>9</td>
          <td>10/9/2022</td>
          <td>
            <button type="button" class="btn btn-primary">
              Feedback
            </button>
          </td>
        </tr>
      </tbody>
    </table>
  );
}

export default ShowScore;
